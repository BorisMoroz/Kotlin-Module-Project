class NotesMenu (var Noteitems: ArrayList<Note>, val firstPhrase1 : String)  : Menu<Note> (Noteitems, firstPhrase1)  {
    override fun createItem() : Note{
        var name : String = ""
        var content : String = ""

        println("Введите имя новой заметки:")
        while (true) {
            name = scanner.nextLine().trim()
            if (name == "") {
                println("Имя заметки не может быть пустым. Попробуйте еще раз..")
            }
            else break
        }

        println("Введите новую заметку:")
        while (true) {
            content = scanner.nextLine().trim()
            if (content == "") {
                println("Заметка не может быть пустой. Попробуйте еще раз..")
            }
            else break
        }

        return Note(name,content)
    }

    fun showNote(note: Note) {
        println("======================")
        println(note.content)
        println("======================")
    }
}