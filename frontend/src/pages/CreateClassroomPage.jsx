import { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function CreateClassroomPage() {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    name: "",
    grade: "",
    schoolYear: "",
    shift: "",
    capacity: "",
  });

  function handleChange(event) {
    const { name, value } = event.target;

    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  }

  async function handleSubmit(event) {
  event.preventDefault();

  const payload = {
    ...formData,
    capacity: Number(formData.capacity),
  };

  console.log("Sending payload:", payload);

  try {
    const response = await fetch("http://localhost:8082/classrooms", {
  method: "POST",
  headers: {
    "Content-Type": "application/json",
  },
  body: JSON.stringify({
    ...formData,
    schoolYear: Number(formData.schoolYear),
    capacity: Number(formData.capacity),
  }),
});

    const text = await response.text();

    console.log("Status:", response.status);
    console.log("Response body:", text);

    if (!response.ok) {
      throw new Error(`POST failed: ${response.status} - ${text}`);
    }

    navigate("/classrooms");
  } catch (error) {
    console.error("Create classroom error:", error);
    alert("Error creating classroom. Veja o console.");
  }
}

  return (
    <div className="container">
      <h1>Create Classroom</h1>

      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="name">Name</label>
          <input id="name" name="name" type="text" value={formData.name} onChange={handleChange} required />
        </div>

        <div>
          <label htmlFor="grade">Grade</label>
          <input id="grade" name="grade" type="text" value={formData.grade} onChange={handleChange} required />
        </div>

        <div>
          <label htmlFor="schoolYear">School Year</label>
          <input id="schoolYear" name="schoolYear" type="text" value={formData.schoolYear} onChange={handleChange} required />
        </div>

        <div>
          <label htmlFor="shift">Shift</label>
          <input id="shift" name="shift" type="text" value={formData.shift} onChange={handleChange} required />
        </div>

        <div>
          <label htmlFor="capacity">Capacity</label>
          <input id="capacity" name="capacity" type="number" min="1" value={formData.capacity} onChange={handleChange} required />
        </div>

        <button type="submit">Create Classroom</button>
      </form>
    </div>
  );
}