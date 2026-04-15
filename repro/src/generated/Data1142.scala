package generated

final case class Data1142(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1142 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1142 = copy(value = value * k)
  def addTag(t: String): Data1142 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1142 = copy(meta = meta.updated(k, v))
  def merge(other: Data1142): Data1142 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1142 {
  given Ordering[Data1142] = Ordering.by(_.id)
  def empty: Data1142 = Data1142(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1142 =
    Data1142(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1142] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
