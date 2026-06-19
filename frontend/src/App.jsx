import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";

import Navbar from "./components/Navbar";

import Dashboard from "./pages/Dashboard";
import StudentsPage from "./pages/StudentsPage";
import StudentDetailsPage from "./pages/StudentDetailsPage";
import CreateStudentPage from "./pages/CreateStudentPage";
import SearchStudentsPage from "./pages/SearchStudentsPage";
import ApiStatusPage from "./pages/ApiStatusPage";
import ClassroomsPage from "./pages/ClassroomsPage";

export default function App() {
  return (
    <BrowserRouter>
      <Navbar />

      <main>
        <Routes>
          <Route path="/" element={<Dashboard />} />
          <Route path="/students" element={<StudentsPage />} />
          <Route path="/students/:id" element={<StudentDetailsPage />} />
          <Route path="/students/new" element={<CreateStudentPage />} />
          <Route path="/students/search" element={<SearchStudentsPage />} />
          <Route path="/classrooms" element={<ClassroomsPage />} />
          <Route path="/api-status" element={<ApiStatusPage />} />
        </Routes>
      </main>
    </BrowserRouter>
  );
}
