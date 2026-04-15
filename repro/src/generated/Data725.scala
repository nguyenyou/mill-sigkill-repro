package generated

final case class Data725(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data725 = copy(name = name.toUpperCase)
  def scale(k: Double): Data725 = copy(value = value * k)
  def addTag(t: String): Data725 = copy(tags = t :: tags)
  def put(k: String, v: String): Data725 = copy(meta = meta.updated(k, v))
  def merge(other: Data725): Data725 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data725 {
  given Ordering[Data725] = Ordering.by(_.id)
  def empty: Data725 = Data725(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data725 =
    Data725(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data725] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
