# NovaCrypto

https://docs.coingecko.com/demo/reference/endpoint-overview


# Android Clean Architecture

Clean Architecture on Android: **UI → Domain → Data** layers with unidirectional data flow.

![Typical Android app architecture](https://vrgsoft.net/wp-content/uploads/2017/12/fe8c82a32b1548b1a297187e24ae755a.png)

## Layers

### Presentation (UI) Layer
Displays data on screen and handles user interaction.
- Compose UI / Views
- ViewModel (state holder)

### Domain Layer *(optional but recommended)*
Pure Kotlin business logic, independent of Android framework.
- Use Cases / Interactors
- Domain Models

### Data Layer
Provides and manages application data.
- Repositories
- Data Sources (network, database, local files)

## Dependency Rule

```
Presentation  →  Domain  ←  Data
```

Outer layers depend inward. The Domain layer knows nothing about Presentation or Data.

## Reference

[Guide to app architecture](https://developer.android.com/topic/architecture) — Android Developers
https://developer.android.com/topic/architecture
