package generated

final case class Data562(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data562 = copy(name = name.toUpperCase)
  def scale(k: Double): Data562 = copy(value = value * k)
  def addTag(t: String): Data562 = copy(tags = t :: tags)
  def put(k: String, v: String): Data562 = copy(meta = meta.updated(k, v))
  def merge(other: Data562): Data562 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data562 {
  given Ordering[Data562] = Ordering.by(_.id)
  def empty: Data562 = Data562(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data562 =
    Data562(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data562] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
