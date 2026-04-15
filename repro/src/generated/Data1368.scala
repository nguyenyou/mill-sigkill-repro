package generated

final case class Data1368(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1368 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1368 = copy(value = value * k)
  def addTag(t: String): Data1368 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1368 = copy(meta = meta.updated(k, v))
  def merge(other: Data1368): Data1368 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1368 {
  given Ordering[Data1368] = Ordering.by(_.id)
  def empty: Data1368 = Data1368(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1368 =
    Data1368(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1368] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
