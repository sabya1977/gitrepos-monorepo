# Employee Leave Management System

A modern, enterprise-grade leave management application built to demonstrate best practices in .NET development, Oracle database integration, and AI-assisted software engineering with GitHub Copilot.

## 🎯 Purpose

This project implements a complete employee leave management system that enables organizations to streamline leave requests, approvals, and balance tracking. Built as a learning initiative, it showcases clean architecture principles, modern web development, and the integration of cutting-edge technologies including Oracle 26ai and AI-powered development workflows.

## 👥 Intended Users

- **Employees** — Submit leave requests, view balances, track approval status
- **Managers** — Review and approve/reject team leave requests, view team availability
- **HR Administrators** — Configure leave types, manage policies, generate reports
- **System Administrators** — Manage users, roles, and system configuration

## ✨ Planned Features

### Core Functionality
- **Leave Request Management** — Create, submit, edit, and cancel leave requests
- **Approval Workflow** — Multi-level approval routing with notifications
- **Leave Balance Tracking** — Real-time accrual, usage, and carry-over calculations
- **Calendar Integration** — Visual leave calendar with team availability
- **Leave Types Support** — Annual, sick, unpaid, bereavement, study leave, and custom types

### Advanced Capabilities
- **Policy Engine** — Configurable accrual rules, blackout periods, and overlap prevention
- **Holiday Management** — Automatic exclusion of weekends and public holidays
- **Reporting & Analytics** — Leave usage reports, team coverage insights, export to Excel
- **Audit Trail** — Complete history of requests, approvals, and policy changes
- **Role-Based Access Control** — Fine-grained permissions for different user types

### User Experience
- **Responsive Web Interface** — Modern React-based UI accessible on desktop and mobile
- **Real-time Notifications** — In-app and email alerts for requests and approvals
- **Search & Filtering** — Advanced search across requests with multiple criteria
- **Dashboard Views** — Personalized dashboards for employees, managers, and HR

## 🛠️ Technology Stack

### Backend
- **.NET 10** — Web API with ASP.NET Core
- **C# 13** — Latest language features and patterns
- **Entity Framework Core** — ORM with Oracle provider
- **MediatR** — CQRS pattern implementation
- **FluentValidation** — Request validation
- **AutoMapper** — Object-to-object mapping

### Database
- **Oracle 26ai** — Enterprise database with AI capabilities
- **Flyway/EF Migrations** — Version-controlled schema management

### Frontend
- **React 18** — Component-based UI framework
- **TypeScript** — Type-safe JavaScript
- **Vite** — Fast build tooling
- **React Query** — Server state management
- **Tailwind CSS** — Utility-first styling

### Development & Testing
- **xUnit** — Unit and integration testing for .NET
- **Vitest** — Frontend testing framework
- **Testcontainers** — Containerized Oracle for integration tests
- **GitHub Actions** — CI/CD pipelines

### Tools & AI
- **Visual Studio Code** — Primary development environment
- **GitHub Copilot** — AI-powered code completion and generation
- **GitHub Copilot Agent** — Autonomous coding assistance and project scaffolding
- **Git** — Version control

## 📁 Project Structure

```
LeaveManagement/
├── src/
│   ├── api/                              # .NET 10 Backend
│   │   ├── LeaveManagement.Api/          # Web API entry point
│   │   ├── LeaveManagement.Application/  # Use cases, DTOs, commands/queries
│   │   ├── LeaveManagement.Domain/       # Business entities and rules
│   │   └── LeaveManagement.Infrastructure/ # Database, external services
│   └── web/                              # React Frontend
│       └── src/
│           ├── features/                 # Feature-based organization
│           ├── components/               # Shared UI components
│           └── api/                      # Backend integration
├── database/
│   ├── migrations/                       # Versioned schema changes
│   └── seeds/                            # Sample and reference data
├── tests/
│   ├── LeaveManagement.Domain.Tests/     # Unit tests
│   ├── LeaveManagement.Application.Tests/ # Use case tests
│   ├── LeaveManagement.Api.Tests/        # Integration tests
│   └── web/                              # Frontend tests
├── docs/
│   ├── architecture.md                   # System design and patterns
│   ├── domain-rules.md                   # Business logic documentation
│   └── api.md                            # API reference
└── .github/
    └── workflows/                        # CI/CD automation
```

### Architecture Principles

- **Clean Architecture** — Dependency inversion with Domain at the center
- **CQRS Pattern** — Separate read and write operations
- **Repository Pattern** — Data access abstraction
- **Feature-Based Organization** — Related code grouped by business capability
- **Test-Driven Development** — Comprehensive test coverage at all layers

## 🎓 Learning Objectives

This project serves as a hands-on learning platform for:

### GitHub Copilot & AI-Assisted Development
- Leveraging GitHub Copilot for code generation and completion
- Using GitHub Copilot Agent for project scaffolding and architecture decisions
- Understanding AI pair programming workflows and best practices
- Exploring prompt engineering for effective code assistance

### Modern .NET Development
- Implementing Clean Architecture in .NET 10
- Building RESTful APIs with ASP.NET Core
- Applying CQRS and MediatR patterns
- Writing maintainable, testable C# code
- Dependency injection and middleware configuration

### Oracle Database Integration
- Working with Oracle 26ai features
- Using Entity Framework Core with Oracle provider
- Database migration strategies and version control
- Query optimization and performance tuning
- Handling Oracle-specific data types and features

### Full-Stack Development
- Building React applications with TypeScript
- Integrating frontend and backend with type-safe APIs
- State management and server communication patterns
- Responsive design and modern UI/UX principles

### Software Engineering Practices
- Clean code principles and SOLID design
- Test-driven development and test pyramid
- Git workflows and version control strategies
- CI/CD pipeline setup with GitHub Actions
- Documentation and knowledge sharing

## 🚀 Getting Started

_(Implementation and setup instructions will be added as the project develops)_

## 📝 Development Status

This project is currently in the **planning and scaffolding phase**. The repository structure is established, and implementation will proceed following Clean Architecture principles with AI-assisted development using GitHub Copilot.

## 🤝 Contributing

This is a learning project. Contributions, suggestions, and feedback are welcome as we explore best practices in modern application development.

## 📄 License

This project is developed for educational purposes.

---

**Built with ❤️ using GitHub Copilot, .NET 10, Oracle 26ai, and React**
