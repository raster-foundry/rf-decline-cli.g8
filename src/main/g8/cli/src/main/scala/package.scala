package $organization$

import io.estatico.newtype.Coercible
import com.monovore.decline.Argument

package object $name;format="norm,word"$ {
  implicit def coercibleArg[R, N](implicit ev: Coercible[Argument[R], Argument[N]], R: Argument[R]) = ev(R)
}