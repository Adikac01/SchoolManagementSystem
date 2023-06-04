import React, { useState, useEffect } from 'react';
import "../tables.css";

function ClassStudents(){
  const pageLocation = window.location.pathname.split('/');
  const studentId = pageLocation[2];
  console.log(studentId);
   const [grades, setGrades] = useState([]);

   useEffect(() => {
     const fetchData = async () => {
       try {
         const response = await fetch(`http://localhost:8080/students/grades/${studentId}`);
         const jsonData = await response.json();
         setGrades(jsonData);
       } catch (error) {
         console.error('Error fetching data:', error);
       }
     };
 
     fetchData();
   }, [studentId]);

   return (
      <div>
        {grades.length > 0 ? (
          <table>
            <thead>
              <tr>
                <th>Value</th>
                <th>Date</th>
                <th>Weight</th>
                <th>Teacher</th>
              </tr>
            </thead>
            <tbody>
              {grades.map((gradeItem) => (
                <tr key={gradeItem.id}>
                  <td className="cell">{gradeItem.value}</td>
                  <td className="cell">{gradeItem.date}</td>
                  <td className="cell">
                     {gradeItem.weight === null ? 1 : gradeItem.weight}
                  </td>
                  <td className="cell">{gradeItem.teacher}</td>
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