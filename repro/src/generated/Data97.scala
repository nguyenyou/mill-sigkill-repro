package generated

final case class Data97(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data97 = copy(name = name.toUpperCase)
  def scale(k: Double): Data97 = copy(value = value * k)
  def addTag(t: String): Data97 = copy(tags = t :: tags)
  def put(k: String, v: String): Data97 = copy(meta = meta.updated(k, v))
  def merge(other: Data97): Data97 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data97 {
  given Ordering[Data97] = Ordering.by(_.id)
  def empty: Data97 = Data97(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data97 =
    Data97(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data97] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
