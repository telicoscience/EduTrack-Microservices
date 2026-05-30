const API_BASE_URL = "http://localhost:8081";

export async function getStudents() {
  const response = await fetch(`${API_BASE_URL}/students`);

  if (!response.ok) {
    throw new Error("Failed to fetch students");
  }

  return response.json();
}

export async function getStudentById(id) {
  const response = await fetch(`${API_BASE_URL}/students/${id}`);

  if (!response.ok) {
    throw new Error("Student not found");
  }

  return response.json();
}

// Função de busca
export async function searchStudentsByName(name) {
  const response = await fetch(
    `${API_BASE_URL}/students/search?name=${encodeURIComponent(name)}`
  );

  if (!response.ok) {
    throw new Error("Failed to search students");
  }

  return response.json();
}