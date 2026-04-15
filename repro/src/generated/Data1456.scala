package generated

final case class Data1456(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1456 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1456 = copy(value = value * k)
  def addTag(t: String): Data1456 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1456 = copy(meta = meta.updated(k, v))
  def merge(other: Data1456): Data1456 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1456 {
  given Ordering[Data1456] = Ordering.by(_.id)
  def empty: Data1456 = Data1456(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1456 =
    Data1456(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1456] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
