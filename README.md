# Diabetic diray

Приложение позволяет пользователю отслеживать содержание сахара в крови.  
Приложение должно отображать список записей пользователя с информацией об уровне сахара и принятом количестве инсулина. Каждая запись в списке должна содержать следующие данные: дату и время измерения, уровень сахара в крови, количество принятого инсулина после измерения, возможность добавить текстовую заметку.  
Приложение должно автоматически строить график, содержащий отметки об уровне сахара и количестве принятого инсулина.  
Приложение должно отображать статистику о средних, минимальных и максимальных значениях уровня сахара и принятого инсулина за неделю, месяц, квартал, год.

## Technologies stack

- Kotlin
- AndroidX
- MVVM
- LiveData
- dataBinding
- Single Activity
- Room
- Navigation Component
- Coroutines
- ktlint

## Linters setup

### ktlint

1. Close Android Studio if open
2. Download `ktlint` file from this [page](https://github.com/pinterest/ktlint/releases)
3. Place this file in root folder of the project
4. Run command `java -jar ktlint --android applyToIDEAProject` 
5. For check your code use command `java -jar ktlint` or `java -jar ktlint -F` for autofix some issues.
