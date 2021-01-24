package ru.kpfu.itis.group903.nurkaev;

import com.google.auto.service.AutoService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

@AutoService(Processor.class)
@SupportedAnnotationTypes(value = {"HtmlForm", "HtmlInput"})
@Slf4j
public class HtmlProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // получить типы с аннотаций HtmlForm
        Set<? extends Element> formAnnotatedElements = roundEnv.getElementsAnnotatedWith(HtmlForm.class);
        for (Element formElement : formAnnotatedElements) {
            // получаем полный путь для генерации html
            String path = HtmlProcessor.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            // User.class -> User.html
            path = path.substring(1) + formElement.getSimpleName().toString() + ".html";
            Path out = Paths.get(path);
            log.info(out.toString());
            log.info("types :" + formElement.getEnclosedElements());
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(out.toFile()))) {
                // получаем параметры аннотации HtmlForm
                HtmlForm htmlForm = formElement.getAnnotation(HtmlForm.class);
                writer.write("<form action='" + htmlForm.action() + "' method='" + htmlForm.method() + "'/>");

                // получаем параметры аннотаций HtmlInput
                List<? extends Element> inputAnnotatedElements = formElement.getEnclosedElements();
                for (Element inputElement : inputAnnotatedElements) {
                    HtmlInput htmlInput = inputElement.getAnnotation(HtmlInput.class);
                    if (htmlInput != null) {
                        writer.write("\t<input type='" + htmlInput.type() +
                                "' name='" + htmlInput.name() +
                                "' placeholder='" + htmlInput.placeholder() + "'/>\n");
                    }
                }
                writer.write("</form>");
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        return true;
    }
}
