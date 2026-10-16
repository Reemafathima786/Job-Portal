# Base44 Setup Notes

## Project Overview
Spring Boot 4.0.1 (Java 21) REST API — a simple Job Portal with CRUD endpoints for jobs.
Uses MySQL 8 via JPA/Hibernate. Swagger UI at `/swagger-ui/index.html`.

## Repository Quirk
The original source `.java` files were missing from the repo (only compiled `.class` files
and one test file existed at the root). Source was reconstructed from bytecode into the
standard Maven layout under `src/main/java/com/example/job/portal/`.

## Architecture
- **Package**: `com.example.job.portal`
- **Endpoints**: `GET /` (returns "index"), `GET/POST /api/jobs`, `GET/DELETE /api/jobs/{id}`
- **Database**: MySQL, auto-creates `jobportal` schema, `ddl-auto=update` creates tables

## Running
```bash
docker compose -f docker-compose.base44.yml up -d
```
App is served on host port 3000 (maps to container's 8080).

## Services
- `db` — MySQL 8.0, root password `jobportalpass`, database `jobportal`
- `app` — Maven 3.9 + JDK 21, runs `mvn spring-boot:run` with source bind-mounted

## No External Secrets
All credentials are local infra (MySQL), wired via compose `environment:`. No external
service keys needed.

## Verification
- `curl http://localhost:3000/` → returns "index"
- `curl http://localhost:3000/api/jobs` → returns job list (JSON array)
- `curl -X POST http://localhost:3000/api/jobs -H "Content-Type: application/json" -d '{"title":"Dev","company":"Co","location":"NYC","description":"Test"}'` → creates a job
- Swagger UI: `http://localhost:3000/swagger-ui/index.html`

## Notes
- No live-reload dev server; Spring Boot runs via `mvn spring-boot:run`. After code edits,
  call `reload_preview` or restart the app service.
- Maven dependencies are cached in the `maven_cache` volume for faster subsequent starts.
