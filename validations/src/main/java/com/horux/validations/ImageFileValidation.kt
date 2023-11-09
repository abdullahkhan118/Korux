package org.horux.validations

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import com.horux.extensions.getExtension
import com.horux.extensions.isNullOrEmpty
import org.springframework.web.multipart.MultipartFile
import kotlin.reflect.KClass


@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Constraint(validatedBy = [ImageFileValidator::class])
annotation class ImageFile(val message: String = "Invalid image file. Only PNG, JPG, and JPEG files are allowed.",
                           val groups: Array<KClass<*>> = [], val payload: Array<KClass<out Any>> = [])

class ImageFileValidator : ConstraintValidator<ImageFile?, MultipartFile?> {
    override fun initialize(constraintAnnotation: ImageFile?) {}
    override fun isValid(file: MultipartFile?, context: ConstraintValidatorContext): Boolean {
        if (file.isNullOrEmpty()) {
            return true // Allow null or empty files (you can adjust this behavior based on your use case)
        }
        return ALLOWED_EXTENSIONS.contains(file.getExtension() ?: return false)
    }

    companion object {
        private val ALLOWED_EXTENSIONS: List<String> = mutableListOf("png", "jpg", "jpeg")
    }
}



