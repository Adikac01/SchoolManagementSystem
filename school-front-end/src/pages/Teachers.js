import React, { useState, useEffect } from 'react';
import "../tables.css";

function Students() {
  const [teachers, setTeachers] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8080/teachers/all');
        const jsonData = await response.json();
        setTeachers(jsonData);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []);

  return (
    <div>
      {teachers.length > 0 ? (
        <table>
          <thead>
            <tr>
              <th>Name</th>
              <th>Subject</th>
            </tr>
          </thead>
          <tbody>
            {teachers.map((teacherItem) => (
              <tr key={teacherItem.id}>
                <td className="cell">{teacherItem.firstName + " " +teacherItem.lastName}</td>
                <td className="cell">{teacherItem.subject}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
}

export default Students;