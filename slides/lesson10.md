## **10. Architecture, accessibility, testing**

---

<img src="slides/images/mindshift.png" width=600 />

---

#### **Imperative 👉 Declarative**

<img src="slides/images/declarative.png" width=600 />

---

#### **`View` (imperative)**

```kotlin
fun updateCount(count: Int) {
  if (count > 0 && !hasBadge()) {
    addBadge()
  } else if (count == 0 && hasBadge()) {
    removeBadge()
  }
  if (count > 99 && !hasFire()) {
    addFire()
    setBadgeText("99+")
  } else if (count <= 99 && hasFire()) {
    removeFire()
  }
  if (count > 0 && !hasPaper()) {
   addPaper()
  } else if (count == 0 && hasPaper()) {
   removePaper()
  }
  if (count <= 99) {
    setBadgeText("$count")
  }
}
```

---

#### **Compose (declarative)**

* Describe what to show
* No thinking about previous state or how to transition from it

```kotlin
@Composable
fun BadgedEnvelope(count: Int) {
  Envelope(fire=count > 99, paper=count > 0) {
    if (count > 0) {
      Badge(text="$count")
    }
  }
}
```

---

#### **Data binding**

* Views had data binding. Expensive for UDF. No diffing supported (except RecyclerView)

* **Compose does diffing by design** 👉 rebind all state, only parts that change recompose 🔝

---

#### **Modeling UI State**

* Make it **exhaustive**
* Incorrect states are impossible
* Allows exhaustive evaluation from UI

```kotlin
sealed interface HeroesUiState {
  object Idle : HeroesUiState
  object Loading : HeroesUiState
  data class Error(val errorMsg: String) : HeroesUiState
  data class Content(val heroes: List<Hero>): HeroesUiState
}
```

---

#### **Modeling variants (2 options)**

Mutable / nullable props 🚨 <span class="error">(impossible states)</span>

```kotlin
sealed interface HeroesUiState {
  // ...
  data class Content(
    val heroes: List<Hero>,
    var loading: Boolean // loading without content? 🤔
  ): HeroesUiState
}
```

Exhaustive (verbosity for correctness)

```kotlin
sealed interface HeroesUiState {
  object Idle : HeroesUiState
  object Loading : HeroesUiState
  data class Error(val errorMsg: String) : HeroesUiState
  data class Content(val heroes: List<Hero>): HeroesUiState
  data class LoadingAndContent(val heroes: List<Hero>): HeroesUiState
}
```

---

#### **Architecture (UDF)**

<img src="slides/images/state_holders.png" width="900">

---

#### **Structuring the app**

* 2 options ✌

  * Single `Activity`, multiple **`Fragments` with Composable content** (`ComposeView`), navigation component

  * Single `Activity`, **Composable screens**, Compose (or custom) navigation

---

* Single Activity (all Compose) vs Fragments with Compose
* Compose Navigation (exercise)
* Dependency injection in Composable functions. Scoping
* Semantic trees. Merged and unmerged
* Merging policies
* Adding semantics to our Composables
* How semantics are handled / wired in Android
* Tools leveraging the semantic trees
* UI testing our Composables
* Screenshot testing our Composables. Shot, Paparazzi, Showkase
* Headless UI tests