package generated

final case class Data759(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data759 = copy(name = name.toUpperCase)
  def scale(k: Double): Data759 = copy(value = value * k)
  def addTag(t: String): Data759 = copy(tags = t :: tags)
  def put(k: String, v: String): Data759 = copy(meta = meta.updated(k, v))
  def merge(other: Data759): Data759 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data759 {
  given Ordering[Data759] = Ordering.by(_.id)
  def empty: Data759 = Data759(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data759 =
    Data759(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data759] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
