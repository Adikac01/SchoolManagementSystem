import {Link, useMatch, useResolvedPath} from "react-router-dom"

export default function Navbar() {
   return <nav className="nav">
      <Link to="/" className="site-title">School</Link>
      <ul>
         <CustomLink to="/students">Students</CustomLink>
         <CustomLink to="/teachers">Teachers</CustomLink>
         <CustomLink to="/classes">Classes</CustomLink>

      </ul>

   </nav>
}

function CustomLink({to, children, ...props}){
   const resolvePath = useResolvedPath(to)
   const isActive = useMatch({path : resolvePath.pathname, end:true})
   return (
      <li className= {isActive ? "active" : ""}>
         <Link to={to}>{children}</Link>
      </li>
   )
}