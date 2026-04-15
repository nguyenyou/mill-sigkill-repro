package generated

final case class Data1370(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1370 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1370 = copy(value = value * k)
  def addTag(t: String): Data1370 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1370 = copy(meta = meta.updated(k, v))
  def merge(other: Data1370): Data1370 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1370 {
  given Ordering[Data1370] = Ordering.by(_.id)
  def empty: Data1370 = Data1370(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1370 =
    Data1370(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1370] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
