# Endpoints planejados

## 1) student-service

- `POST /students`
- `GET /students`
- `GET /students/{id}`
- `PUT /students/{id}`
- `DELETE /students/{id}`

### Entidade

`Student`
- id
- name
- registrationNumber
- birthDate
- active

---

## 2) classroom-service

- `POST /classrooms`
- `GET /classrooms`
- `POST /classrooms/{id}/students/{studentId}`
- `GET /classrooms/{id}/students`

### Entidades

`Classroom`
- id
- name
- grade
- year

`Enrollment`
- id
- studentId
- classroomId

---

## 3) activity-service

- `POST /activities`
- `GET /activities`
- `GET /activities/classroom/{classroomId}`

### Entidade

`Activity`
- id
- title
- subject
- classroomId
- maxScore
- dueDate

---

## 4) grade-service

- `POST /grades`
- `GET /grades/student/{studentId}`
- `GET /grades/student/{studentId}/average`

### Entidade

`Grade`
- id
- studentId
- activityId
- score

---

## 5) notification-service

Consumidor RabbitMQ de:
- `student.created`
- `activity.created`
- `grade.created`

Função inicial: logging simulando envio de notificações.
