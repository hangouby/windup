import org.jboss.windup.config.operation.GraphOperation;
import org.jboss.windup.config.GraphRewrite;
import org.jboss.windup.config.phase.RulePhase;
import org.jboss.windup.config.metadata.RuleMetadataType;
import org.jboss.windup.config.phase.RulePhase;
import org.jboss.windup.config.phase.PostMigrationRulesPhase;
import org.jboss.windup.reporting.config.classification.Classification;
import org.jboss.windup.reporting.config.Hint;
import org.jboss.windup.reporting.config.Link;
import org.jboss.windup.rules.apps.java.condition.JavaClass;
import org.jboss.windup.ast.java.data.TypeReferenceLocation;
import org.jboss.windup.rules.apps.xml.condition.XmlFile;
import org.jboss.windup.util.Logging;
import org.ocpsoft.rewrite.config.True;
import org.ocpsoft.rewrite.context.EvaluationContext;


ruleSet("ExampleRhamtJavaGroovy").setPhase(PostMigrationRulesPhase.class)

        .addRule()
        
        .when(XmlFile.matchesXpath("/abc:ejb-jar")
              .namespace("abc", "http://java.sun.com/xml/ns/javaee"))
        
        .perform(Classification.as("Maven POM File")
            .with(Link.to("Apache Maven POM Reference", "http://maven.apache.org/pom.html"))
            .withEffort(0)
          .and(Hint.withText("simple text").withEffort(2))
        )
        .withMetadata(RuleMetadataType.TAGS, "Basic")
