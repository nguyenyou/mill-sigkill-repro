package generated

final case class Data607(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data607 = copy(name = name.toUpperCase)
  def scale(k: Double): Data607 = copy(value = value * k)
  def addTag(t: String): Data607 = copy(tags = t :: tags)
  def put(k: String, v: String): Data607 = copy(meta = meta.updated(k, v))
  def merge(other: Data607): Data607 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data607 {
  given Ordering[Data607] = Ordering.by(_.id)
  def empty: Data607 = Data607(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data607 =
    Data607(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data607] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
