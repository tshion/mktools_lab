#set( $nameBinding = "${NAME}Binding" )
#set( $nameLayout = $NAME.replaceAll("([A-Z])", "_$1").replaceAll("^_(.*)", "$1").toLowerCase() )


#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import androidx.fragment.app.Fragment

/**
 *
 */
class ${NAME}Fragment : Fragment(R.layout.${nameLayout}) {

    private var binding: ${nameBinding}? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ${nameBinding}.bind(view)
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}
