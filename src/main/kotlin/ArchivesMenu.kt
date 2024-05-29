class ArchivesMenu(var Archiveitems: ArrayList<Archive>, val firstPhrase1 : String)  : Menu<Archive> (Archiveitems, firstPhrase1) {

    override fun createItem() : Archive {

        var name : String = ""

        println("Введите имя нового архива:")

        while (true) {
            name = scanner.nextLine().trim()
            if (name == "") {
                println("Имя архива не может быть пустым. Попробуйте еще раз..")
            }
            else break
        }
        return Archive(name)
    }
}