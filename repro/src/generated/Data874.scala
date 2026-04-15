package generated

final case class Data874(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data874 = copy(name = name.toUpperCase)
  def scale(k: Double): Data874 = copy(value = value * k)
  def addTag(t: String): Data874 = copy(tags = t :: tags)
  def put(k: String, v: String): Data874 = copy(meta = meta.updated(k, v))
  def merge(other: Data874): Data874 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data874 {
  given Ordering[Data874] = Ordering.by(_.id)
  def empty: Data874 = Data874(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data874 =
    Data874(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data874] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
