package generated

final case class Data1466(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1466 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1466 = copy(value = value * k)
  def addTag(t: String): Data1466 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1466 = copy(meta = meta.updated(k, v))
  def merge(other: Data1466): Data1466 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1466 {
  given Ordering[Data1466] = Ordering.by(_.id)
  def empty: Data1466 = Data1466(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1466 =
    Data1466(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1466] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
