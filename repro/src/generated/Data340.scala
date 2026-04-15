package generated

final case class Data340(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data340 = copy(name = name.toUpperCase)
  def scale(k: Double): Data340 = copy(value = value * k)
  def addTag(t: String): Data340 = copy(tags = t :: tags)
  def put(k: String, v: String): Data340 = copy(meta = meta.updated(k, v))
  def merge(other: Data340): Data340 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data340 {
  given Ordering[Data340] = Ordering.by(_.id)
  def empty: Data340 = Data340(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data340 =
    Data340(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data340] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
