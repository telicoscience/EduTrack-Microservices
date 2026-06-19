const API_URL = "http://localhost:8082";

export async function getClassrooms() {
  const response = await fetch(`${API_URL}/classrooms`);

  if (!response.ok) {
    throw new Error("Failed to fetch classrooms");
  }

  return response.json();
}

export async function getClassroomById(id) {
  const response = await fetch(`${API_URL}/classrooms/${id}`);

  if (!response.ok) {
    throw new Error("Classroom not found");
  }

  return response.json();
}

export async function createClassroom(classroom) {
  const response = await fetch(`${API_URL}/classrooms`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(classroom),
  });

  if (!response.ok) {
    throw new Error("Failed to create classroom");
  }

  return response.json();
}
