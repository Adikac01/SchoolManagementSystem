import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import "../tables.css";

function Students() {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8080/students/all');
        const jsonData = await response.json();
        setStudents(jsonData);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []);

  return (
    <div>
      {students.length > 0 ? (
        <table>
          <thead>
            <tr>
              <th>Name</th>
              <th>Class</th>
            </tr>
          </thead>
          <tbody>
            {students.map((studentItem) => (
              <tr key={studentItem.id}>
               <td className='cell'>
                  <Link to={`/students/${studentItem.id}/grades`}>
                    <div style={{width: "100%",height:"100%"}}>
                      {studentItem.firstName + " " +studentItem.lastName}
                    </div>
                  </Link>
                </td>
                <td className="cell">{studentItem.class}</td>
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