package com.karn.javatricks.features.sealedexp;


public class SealedClassTest {
}
sealed class ParentSealed1{

}
final class ChildSealed1 extends ParentSealed1{

}
final class ChildSealed2 extends ParentSealed1{

}
non-sealed class ChildSealed3 extends ParentSealed1{

}
/*it is possible to extend one sealed class by another but the next sealed class again must
        be extended by non-sealed or final class or again a sealed class
        */
//sealed class ChildSealed4 extends ParentSealed1{
//
//}
sealed class ParentSealed2 permits ChildSealed5{

}
final class ChildSealed5 extends ParentSealed2{

}
//no permitted
//final class ChildSealed6 extends ParentSealed2{
//
//}

