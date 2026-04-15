package generated

final case class Data1193(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1193 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1193 = copy(value = value * k)
  def addTag(t: String): Data1193 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1193 = copy(meta = meta.updated(k, v))
  def merge(other: Data1193): Data1193 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1193 {
  given Ordering[Data1193] = Ordering.by(_.id)
  def empty: Data1193 = Data1193(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1193 =
    Data1193(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1193] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
