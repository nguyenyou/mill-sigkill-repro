package generated

final case class Data430(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data430 = copy(name = name.toUpperCase)
  def scale(k: Double): Data430 = copy(value = value * k)
  def addTag(t: String): Data430 = copy(tags = t :: tags)
  def put(k: String, v: String): Data430 = copy(meta = meta.updated(k, v))
  def merge(other: Data430): Data430 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data430 {
  given Ordering[Data430] = Ordering.by(_.id)
  def empty: Data430 = Data430(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data430 =
    Data430(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data430] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
