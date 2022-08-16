package compileDep

import groovy.transform.CompileStatic
import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation
import transitiveDep.MyLogger

@CompileStatic
@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class MyTransformation implements ASTTransformation {
    {
        println "Initializing MyTransformation"
    }

    @Override
    void visit(ASTNode[] nodes, SourceUnit source) {
        // call into transitive dependency
        MyLogger.log(source.name)
    }
}
