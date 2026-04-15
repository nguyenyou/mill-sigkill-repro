package generated

final case class Data578(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data578 = copy(name = name.toUpperCase)
  def scale(k: Double): Data578 = copy(value = value * k)
  def addTag(t: String): Data578 = copy(tags = t :: tags)
  def put(k: String, v: String): Data578 = copy(meta = meta.updated(k, v))
  def merge(other: Data578): Data578 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data578 {
  given Ordering[Data578] = Ordering.by(_.id)
  def empty: Data578 = Data578(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data578 =
    Data578(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data578] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
