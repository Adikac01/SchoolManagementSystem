import Navbar from "./Navbar";
import Home from "./pages/Home";
import  {Route, Routes} from "react-router-dom"
import Classes from "./pages/Classes";
import Students from "./pages/Students";
import Teachers from "./pages/Teachers";
import ClassStudents from "./pages/ClassStudents"
import StudentGrades from "./pages/StudentGrades"

function App() {

  return (
    <>
      <Navbar/>
      <div className="container">
        <Routes>
          <Route path="/" element={<Home/>} />
          <Route path="/classes" element={<Classes />} />
          <Route path="/classes/:classId/students" element={<ClassStudents />} />
          <Route path="/students" element={<Students/>} />
          <Route path="/students/:studentId/grades" element={<StudentGrades />} />
          <Route path="/teachers" element={<Teachers/>} />
        </Routes>
        
      </div>
    </>
  )
}

export default App;
