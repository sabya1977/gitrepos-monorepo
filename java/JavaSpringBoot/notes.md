**When to use String, StringBuilder and StringBuffer**

        String Vs StringBuilder Vs StringBuffer
                         │
          ┌──────────────┼──────────────┐
          │              │              │
          ▼              ▼              ▼
       String      StringBuilder   StringBuffer
          │              │              │
      Immutable        Mutable        Mutable
                         │              │
                    Not synchronized  Synchronized

---

                Which One Should You Use?
                       │
                       ▼
             ┌──────────────────┐
             │ Will it be       │
             │ repeatedly       │
             │ modified?        │
             └────────┬─────────┘
                  No  │  Yes
                      │
          ┌───────────┘
          ▼
       String
                      │
                      ▼
             ┌──────────────────┐
             │ Multiple threads │
             │ modifying/shared │
             │ buffer?          │
             └────────┬─────────┘
                  No  │  Yes
                      │
              ▼       ▼
       StringBuilder  StringBuffer