package com.github.leventarican.apple

class Datasource {

    fun loadProgrammingLanguages(): List<ProgrammingLang> {
        return listOf<ProgrammingLang>(
            ProgrammingLang(R.string.pl0),
            ProgrammingLang(R.string.pl1),
            ProgrammingLang(R.string.pl2),
            ProgrammingLang(R.string.pl3),
            ProgrammingLang(R.string.pl4),
            ProgrammingLang(R.string.pl5)
        )
    }
}