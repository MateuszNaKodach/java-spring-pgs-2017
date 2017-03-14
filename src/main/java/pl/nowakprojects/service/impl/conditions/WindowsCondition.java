package pl.nowakprojects.service.impl.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by Mateusz on 14.03.2017.
 */
public class WindowsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata){
        return context.getEnvironment().getProperty("os.name").equals("Linux");
    }
}
