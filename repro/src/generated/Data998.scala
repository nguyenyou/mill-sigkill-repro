package generated

final case class Data998(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data998 = copy(name = name.toUpperCase)
  def scale(k: Double): Data998 = copy(value = value * k)
  def addTag(t: String): Data998 = copy(tags = t :: tags)
  def put(k: String, v: String): Data998 = copy(meta = meta.updated(k, v))
  def merge(other: Data998): Data998 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data998 {
  given Ordering[Data998] = Ordering.by(_.id)
  def empty: Data998 = Data998(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data998 =
    Data998(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data998] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
