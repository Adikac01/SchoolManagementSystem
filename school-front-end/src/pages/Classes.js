import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

import "../tables.css";

function Classes() {
  const [classes, setClasses] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8080/classes/all');
        const jsonData = await response.json();
        setClasses(jsonData);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []);

  return (
    <div>
      {classes.length > 0 ? (
        <table>
          <thead>
            <tr>
              <th>Class Name</th>
              <th>Year</th>
              <th>Profile</th>
            </tr>
          </thead>
          <tbody>
            {classes.map((classItem) => (
              <tr key={classItem.id}>
                <td className='cell'>
                  <Link to={`/classes/${classItem.id}/students`}>
                    <div style={{width: "100%",height:"100%"}}>
                      {classItem.className}
                    </div>
                  </Link>
                </td>
                <td className="cell">{classItem.year}</td>
                <td className="cell">{classItem.profile}</td>
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

export default Classes;