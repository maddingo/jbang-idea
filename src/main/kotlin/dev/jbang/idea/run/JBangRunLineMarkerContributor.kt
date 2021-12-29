package dev.jbang.idea.run

import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import dev.jbang.intellij.plugins.jbang.JBANG_DECLARE
import dev.jbang.intellij.plugins.jbang.jbangIcon

class JBangRunLineMarkerContributor : RunLineMarkerContributor() {
    override fun getInfo(element: PsiElement): Info? {
        if (element is PsiComment) {
            if (element.text.startsWith(JBANG_DECLARE)) {
                return Info(jbangIcon, { "Run by JBang" }, JBangRunScriptAction(element))
            }
        }
        return null
    }
}