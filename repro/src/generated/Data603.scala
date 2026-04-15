package generated

final case class Data603(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data603 = copy(name = name.toUpperCase)
  def scale(k: Double): Data603 = copy(value = value * k)
  def addTag(t: String): Data603 = copy(tags = t :: tags)
  def put(k: String, v: String): Data603 = copy(meta = meta.updated(k, v))
  def merge(other: Data603): Data603 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data603 {
  given Ordering[Data603] = Ordering.by(_.id)
  def empty: Data603 = Data603(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data603 =
    Data603(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data603] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
