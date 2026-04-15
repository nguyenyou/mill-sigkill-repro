package generated

final case class Data502(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data502 = copy(name = name.toUpperCase)
  def scale(k: Double): Data502 = copy(value = value * k)
  def addTag(t: String): Data502 = copy(tags = t :: tags)
  def put(k: String, v: String): Data502 = copy(meta = meta.updated(k, v))
  def merge(other: Data502): Data502 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data502 {
  given Ordering[Data502] = Ordering.by(_.id)
  def empty: Data502 = Data502(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data502 =
    Data502(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data502] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
