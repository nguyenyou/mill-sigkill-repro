package generated

final case class Data986(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data986 = copy(name = name.toUpperCase)
  def scale(k: Double): Data986 = copy(value = value * k)
  def addTag(t: String): Data986 = copy(tags = t :: tags)
  def put(k: String, v: String): Data986 = copy(meta = meta.updated(k, v))
  def merge(other: Data986): Data986 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data986 {
  given Ordering[Data986] = Ordering.by(_.id)
  def empty: Data986 = Data986(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data986 =
    Data986(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data986] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
