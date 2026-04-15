package generated

final case class Data221(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data221 = copy(name = name.toUpperCase)
  def scale(k: Double): Data221 = copy(value = value * k)
  def addTag(t: String): Data221 = copy(tags = t :: tags)
  def put(k: String, v: String): Data221 = copy(meta = meta.updated(k, v))
  def merge(other: Data221): Data221 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data221 {
  given Ordering[Data221] = Ordering.by(_.id)
  def empty: Data221 = Data221(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data221 =
    Data221(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data221] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
