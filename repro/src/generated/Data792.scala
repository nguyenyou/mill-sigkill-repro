package generated

final case class Data792(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data792 = copy(name = name.toUpperCase)
  def scale(k: Double): Data792 = copy(value = value * k)
  def addTag(t: String): Data792 = copy(tags = t :: tags)
  def put(k: String, v: String): Data792 = copy(meta = meta.updated(k, v))
  def merge(other: Data792): Data792 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data792 {
  given Ordering[Data792] = Ordering.by(_.id)
  def empty: Data792 = Data792(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data792 =
    Data792(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data792] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
