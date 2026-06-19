import { Link } from "react-router-dom";

export default function Navbar() {
    return (
        <nav>
            <Link to="/">Dashboard</Link> |{" "}
            <Link to="/students">Students</Link> |{" "}
            <Link to="/classrooms">Classrooms</Link> |{" "}
            <Link to="/students/new">Create</Link> |{" "}
            <Link to="/students/search">Search</Link> |{" "}
            <Link to="/api-status">API Status</Link>
        </nav>
    );
}
