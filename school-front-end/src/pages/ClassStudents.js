import React, { useState, useEffect } from 'react';
import "../tables.css";

function ClassStudents(){
  const pageLocation = window.location.pathname.split('/');
  const classId = pageLocation[2];
  console.log(classId);
   const [students, setStudents] = useState([]);

   useEffect(() => {
     const fetchData = async () => {
       try {
         const response = await fetch(`http://localhost:8080/classes/studentsOf/${classId}`);
         const jsonData = await response.json();
         setStudents(jsonData);
       } catch (error) {
         console.error('Error fetching data:', error);
       }
     };
 
     fetchData();
   }, [classId]);

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
                  <td className="cell">{studentItem.firstName + " " +studentItem.lastName}</td>
                  <td className="cell">{studentItem.class}</td>
                </tr>
              ))}
            </tbody>
          </table>
        ) : (
          <p>No students found</p>
        )}
      </div>
    );
}

export default ClassStudents;