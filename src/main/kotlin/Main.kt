import java.util.Scanner
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    var archives = ArrayList<Archive>()

    var userInput : Int = 0

    var archivesMenu : ArchivesMenu = ArchivesMenu(archives, "Создать новый архив")
    var currentArchive : Archive = Archive("")
    var currentMenu : CurrentMenu = CurrentMenu.ARCHIVES

    while (true) {
        when (currentMenu) {
            CurrentMenu.ARCHIVES -> {
                userInput = archivesMenu.userInputProcessing()
                when (userInput) {
                    archives.size +1 -> break
                    0 ->  continue
                    else -> {
                        currentArchive = archives[userInput-1]
                        currentMenu = CurrentMenu.NOTES
                        continue
                    }
                }
            }

            CurrentMenu.NOTES -> {
                val notesMenu : NotesMenu = NotesMenu(currentArchive.notes, "Создать новую заметку")
                userInput = notesMenu.userInputProcessing()
                when (userInput) {
                    currentArchive.notes.size+1 -> {
                        currentMenu = CurrentMenu.ARCHIVES
                        continue
                    }
                    0 ->  continue
                    else -> {
                        notesMenu.showNote(currentArchive.notes[userInput-1])
                    }
                }
            }
            else -> continue
        }
    }
}

enum class CurrentMenu{
    ARCHIVES,
    NOTES,
}








