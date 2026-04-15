package generated

final case class Data881(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data881 = copy(name = name.toUpperCase)
  def scale(k: Double): Data881 = copy(value = value * k)
  def addTag(t: String): Data881 = copy(tags = t :: tags)
  def put(k: String, v: String): Data881 = copy(meta = meta.updated(k, v))
  def merge(other: Data881): Data881 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data881 {
  given Ordering[Data881] = Ordering.by(_.id)
  def empty: Data881 = Data881(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data881 =
    Data881(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data881] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
